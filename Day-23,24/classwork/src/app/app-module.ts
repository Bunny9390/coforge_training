import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Employee } from './employee/employee';
import { Student } from './student/student';
import { Product } from './product/product';
import { Company } from './company/company';
import { Registration } from './registration/registration';
// import { Counter } from './Counter/counter';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [App, Employee, Student, Product, Company, Registration,],
  imports: [BrowserModule, AppRoutingModule,FormsModule],
  providers: [provideBrowserGlobalErrorListeners()],
  bootstrap: [App],
})
export class AppModule {}
