import { Component, OnInit } from '@angular/core';
import { BankService } from '../../services/bank.service';
import { Bank } from '../../model/Bank';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-bank-list',
  templateUrl: './bank-list.component.html',
  styleUrls: ['./bank-list.component.css']
})
export class BankListComponent implements OnInit {

  banks: Bank[] = [];

  newBankForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    address: new FormControl('', [Validators.required]),
  })

  constructor(private bankServive:BankService) {}


  ngOnInit(): void {
    this.bankServive.getAllBanks().subscribe(
      (data) => {
        console.log(data); 
        this.banks = data
      }
    )
  }

  onSubmit(): void {
    let name = this.newBankForm.value.name!
    let address = this.newBankForm.value.address!
    this.bankServive.createBank(name, address).subscribe((newBank) => {
      console.log(newBank);
      this.banks.push(newBank)
    })
    this.newBankForm.reset()
  }

  deleteBank(bank: Bank):void {
    this.bankServive.deleteBank(bank).subscribe(() => this.banks = this.banks.filter((b) => { return (b.id != bank.id)}))
  }

}
