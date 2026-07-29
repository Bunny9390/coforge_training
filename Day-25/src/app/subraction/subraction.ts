import { Component } from '@angular/core';
import { CalculatorService } from '../calculator-service';

@Component({
  selector: 'app-subraction',
  standalone: false,
  templateUrl: './subraction.html',
  styleUrl: './subraction.css',
})
export class Subraction {
  result:string;
  constructor(private calculatorService: CalculatorService) {
    this.result = "Subraction : " + this.calculatorService.subtract(20, 10).toString();

  }
}
