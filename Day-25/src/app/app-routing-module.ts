import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home-component/home-component';
import { ContactComponent } from './contact-component/contact-component';
import { AboutComponent } from './about-component/about-component';

const routes: Routes = [
  {path:'Home',component:HomeComponent},
  {path:'Contact',component:ContactComponent},
  {path:'About',component:AboutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
