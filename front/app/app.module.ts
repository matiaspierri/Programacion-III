import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { UserInfoComponent } from './componentes/user-info/user-info.component';
import { InfoComponent } from './componentes/user-info/info/info.component';
import { CardsComponent } from './componentes/user-info/cards/cards.component';
import { CardInfoComponent } from './componentes/user-info/cards/card-info/card-info.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserPurchasesComponent } from './componentes/user-purchases/user-purchases.component';
import { HomeComponent } from './componentes/home/home.component';
import { ContactComponent } from './componentes/contact/contact.component';
import { NotFoundComponent } from './componentes/not-found/not-found.component';
import { SectionAComponent } from './componentes/user-purchases/section-a/section-a.component';
import { SectionBComponent } from './componentes/user-purchases/section-b/section-b.component';
import { AppRoutingModule } from './app-routing.module';
import { BankListComponent } from './componentes/bank-list/bank-list.component';
import { LoginComponent } from './componentes/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    UserInfoComponent,
    InfoComponent,
    CardsComponent,
    CardInfoComponent,
    UserPurchasesComponent,
    HomeComponent,
    ContactComponent,
    NotFoundComponent,
    SectionAComponent,
    SectionBComponent,
    BankListComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
