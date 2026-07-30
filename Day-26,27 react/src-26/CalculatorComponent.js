import React, { Component } from 'react';

class CalculatorComponent extends Component {
    constructor(props) {
        super(props);
        this.state={
            n1:0,
            n2:0,
            result:""
        }

    }
    addition = () => {
        this.setState({
            result : "Addition :"+(parseInt(this.state.n1) + parseInt(this.state.n2))
        });
    }
    subraction = () => {
        this.setState({
            result : "Subraction:" +(parseInt(this.state.n1) - parseInt(this.state.n2))
        });
    }
    multiplication = () => {
        this.setState({
            result : "Multiplication:" +(parseInt(this.state.n1) * parseInt(this.state.n2))
        });
    }
    division = () => {
        this.setState({
            result : "Division:" +(parseInt(this.state.n1) / parseInt(this.state.n2))
        });
    }


    render() {
        return (
            <>
            <h1>Calculator Application</h1>
            <b>Enter num1 <input type="text" value={this.state.n1} onChange={(event)=>this.setState({n1:event.target.value})}></input></b> <br></br>
            <b>Enter num2 <input type="text" value={this.state.n2} onChange={(event)=>this.setState({n2:event.target.value})}></input></b>
            <br></br>

            <button onClick={this.addition}>Addition</button>
            <button onClick={this.subraction}>Subraction</button>
            <button onClick={this.multiplication}>Multiplication</button>
            <button onClick={this.division}>Division</button>
            
            <br></br>
            <h1>{this.state.result}</h1>
            
            
            </>


        );

    }

}
export default CalculatorComponent;