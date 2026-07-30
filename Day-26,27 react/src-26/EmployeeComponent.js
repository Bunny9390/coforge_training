import React, { Component } from 'react';

class EmployeeComponent extends Component {
    constructor(props) {
        super(props);
        this.state={
            eid:101,
            ename : "Bunny",
            esalary : 10000,
            dno : 10
        }
    }
    render() {
        return (
            <>
            <h1>Employee Details</h1>
            <h1>Organization: {this.props.org}</h1>
            <h1>ID:{this.state.eid}</h1>
            <h1>Name:{this.state.ename}</h1>
            <h1>Salary:{this.state.esalary}</h1>
            <h1>Department ID:{this.state.dno}</h1>
            </>

        )};
    }


export default EmployeeComponent;