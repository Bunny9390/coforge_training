import { Component } from '@angular/core';

@Component({
  selector: 'app-structural-component',
  standalone: false,
  templateUrl: './structural-component.html',
  styleUrl: './structural-component.css',
})
export class StructuralComponent {

  myDivStyle: string;
  myButtonStyle: {};
  message: string;
  flag: boolean;

  vehicles: string[];
  selectedVehicle: string;

  constructor() {

    this.myDivStyle = 'MyDiv';

    this.myButtonStyle = {
      'background-color': 'blue',
      'color': 'white',
      'padding': '10px',
      'border': 'none',
      'border-radius': '5px',
      'cursor': 'pointer'
    };

    this.message = 'Angular Structural Directives';
    this.flag = true;

    this.vehicles = ['Car', 'Bike', 'Bus', 'Truck'];

    this.selectedVehicle = '';
  }

  showDiv() {
    this.flag = !this.flag;
  }

  setSelectedVehicle(vehicle: string) {
    this.selectedVehicle = vehicle;
  }

}