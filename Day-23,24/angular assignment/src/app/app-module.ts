import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Childapp } from './childapp/childapp';
import { Childapp2 } from './childapp2/childapp2';
import { FormsModule } from '@angular/forms';
import { StructuralComponent } from './day-2/structural-component/structural-component';
import { CalculatorService } from './calculator-service';
import { Addition } from './addition/addition';
import { Subraction } from './subraction/subraction';
import { StructuralDirective } from './structural-directive/structural-directive';
import { HomeComponent } from './home-component/home-component';
import { AboutComponent } from './about-component/about-component';
import { ContactComponent } from './contact-component/contact-component';
// import { Employee } from './employee/employee';

@NgModule({
  declarations: [
    App,
    Childapp,
    Childapp2,
    StructuralComponent,
    Addition,
    Subraction,
    StructuralDirective,
    HomeComponent,
    AboutComponent,
    ContactComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideBrowserGlobalErrorListeners(), CalculatorService],
  bootstrap: [App],
})
export class AppModule {}
