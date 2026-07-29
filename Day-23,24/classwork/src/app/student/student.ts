import { Component } from '@angular/core';

@Component({
  selector: 'app-student',
  standalone: false,
  templateUrl: './student.html',
  styleUrl: './student.css',
})
export class Student {
  name: string = "";
  course: string = "";
  clg: string = "";
  photo : string = "";
  width : number = 200;
  height : number = 200;
  constructor() {
    this.name = "Bunny";
    this.course = "Training";
    this.clg = "Vnr vjiet";
    this.photo = "picture1.jpg";
    this.width = 200;
    this.height = 200;

  }

}
