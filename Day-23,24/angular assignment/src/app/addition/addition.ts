import { Component } from '@angular/core';
import { CalculatorService } from '../calculator-service';
@Component({
  selector: 'app-addition',
  standalone: false,
  templateUrl: './addition.html',
  styleUrl: './addition.css',
})
export class Addition {
  result:string;
  num1 :number = 0;
  nums2 :number = 0;
  constructor(private calculatorService: CalculatorService) {
    this.result = "";


  }
  getAddition() {
    this.result = this.calculatorService.add(this.num1, this.nums2).toString();
  }


}
