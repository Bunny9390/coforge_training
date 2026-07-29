import { Injectable, Service } from '@angular/core';

@Injectable()
export class CalculatorService {

    add(a: number, b:number): number{
        return a+b;
    }

    subtract(a: number, b:number): number{
        return a-b;
    }

    multiplication(a: number, b:number): number{
        return a*b;
    }
    division(a: number, b:number): number{
        return a/b;
    }

    constructor() {

    }
}