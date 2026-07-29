import { Component } from '@angular/core';

@Component({
  selector: 'app-company',
  standalone: false,
  templateUrl: './company.html',
  styleUrl: './company.css',
})
export class Company {
  companyName: string;
  companyLocation: string;
  companyCEO: string;
  companyRevenue: number;

  constructor() {
    this.companyName = "pichi ekista fastfood";
    this.companyLocation = "Hyderabad";
    this.companyCEO = "Anirudh";
    this.companyRevenue = 50000;
  }
}
