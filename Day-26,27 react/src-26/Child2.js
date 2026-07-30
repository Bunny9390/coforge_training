import { Component } from "react";

class Child2 extends Component {
    render() {
     return (
        <>
            Welcome to Child-2
            <br></br>
            <p>Name : {this.props.name}</p>
            <p>Email : {this.props.email}</p>
        </>
     );   
    }
}

Child2.defaultProps = {
        name : "abc",
        email : "abc@gmail.com"
    }

export default Child2;