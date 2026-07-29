import { Component } from '@angular/core';

@Component({
  selector: 'app-employee',
  standalone: false,
  templateUrl: './employee.html',
  styleUrl: './employee.css',
})
export class Employee {
  emp_id: number;
  emp_name: string
  emp_dapt: string;
  emp_salary: number;

  constructor() {
    this.emp_id = 101;
    this.emp_name = "Bunny";
    this.emp_dapt = "Angular";
    this.emp_salary = 10000;
  }
}
