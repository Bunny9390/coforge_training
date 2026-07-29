import { Component } from '@angular/core';

@Component({
  selector: 'app-registration',
  standalone: false,
  templateUrl: './registration.html',
  styleUrl: './registration.css',
})
export class Registration {
  name: string;
  age: number
  email: string;
  constructor() {
    this.name = "";
    this.age = 0;
    this.email = "";
  }

  register() {
    console.log("Name: " + this.name);
    console.log("Age: " + this.age);
    console.log("Email: " + this.email);
    alert("Registration Successful!");

  }
  reset() {
    this.name = "";
    this.age = 0;
    this.email = "";
  }

}
