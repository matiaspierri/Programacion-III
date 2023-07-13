import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserInfoComponent } from './componentes/user-info/user-info.component';
import { UserPurchasesComponent } from './componentes/user-purchases/user-purchases.component';
import { HomeComponent } from './componentes/home/home.component';
import { ContactComponent } from './componentes/contact/contact.component';
import { NotFoundComponent } from './componentes/not-found/not-found.component';
import { SectionAComponent } from './componentes/user-purchases/section-a/section-a.component';
import { SectionBComponent } from './componentes/user-purchases/section-b/section-b.component';
import { BankListComponent } from './componentes/bank-list/bank-list.component';
import { LoginComponent } from './componentes/login/login.component';

const routes : Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'info', component: UserInfoComponent},
  {path: 'purchases', component: UserPurchasesComponent,
    children: [
      {path: 'section-a', component: SectionAComponent},
      {path: 'section-b', component: SectionBComponent}
    ] },
  {path: 'banks', component: BankListComponent},
  {path: 'contact', component: ContactComponent},
  {path: '**', component: NotFoundComponent }
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ], 
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
