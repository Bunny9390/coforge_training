import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  name : string;
  age : number;
  email : string;
  imagePath:string;
  width : number;
  height : number;
  myStyle = {};
  myClass = "";
  fname : string = "";
  
  constructor() {
    this.name = "Bunny";
    this.age = 21;
    this.email = "bunny@gmail.com"
    this.imagePath = "picture.jpg"
    this.width = 200;
    this.height = 200;
    this.myStyle = "zoomout";
    this.myClass = "zoomin";
   

    // this.fname = "Bunny-Anirudh";

  }

  getAddition(a: number, b: number): number {
    return a + b;
  }
  
  changeName() {
    if(this.name === "Engu Bunny") 
      this.name = "Bunny";
    else
      this.name = "Engu Bunny";
  }

  zoominout() {
    if(this.myClass === "zoomin")
      this.myClass = "zoomout";
    else
      this.myClass = "zoomin";
  }}
