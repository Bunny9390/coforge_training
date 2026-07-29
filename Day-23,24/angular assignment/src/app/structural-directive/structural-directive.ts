import { Component } from '@angular/core';

@Component({
  selector: 'app-structural-directive',
  standalone: false,
  templateUrl: './structural-directive.html',
  styleUrl: './structural-directive.css',
})
export class StructuralDirective {
  myDivStyle : string;
  myButtonStyle : {};
  message : string;
  flag : boolean;
  vehicles : string[];
  selectedVehicle : string;

  constructor() {
    this.myDivStyle = "MyDiv";
    this.myButtonStyle = {backgroundColor : "blue", color: "green", padding: '10px'};
    this.message = "Angular Structural Directives";
    this.flag = true;
    this.vehicles = ['car', 'bike', 'bus','truck'];
    this.selectedVehicle = "";
  }

  showHideDiv() {
    this.flag =!this.flag;
  }

  setselectedVehicle(vehicle : string) {
    this.selectedVehicle = vehicle;

  }
}