export class Bank {

    id?: number
    name?: string
    address?: string
    totalSpent?: number

    constructor(name:string, address:string) {
        this.name = name
        this.address = address
    }
}