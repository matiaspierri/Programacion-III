import { Card } from "./Card"
import { Role } from "./Role"

export class User {
    id?: string
    username?: string
    password?: string
    role?: Role 
    cards?: Card[]

    constructor(id: string, username: string, password: string, role: Role, cards: Card[]) {
        this.id = id
        this.username = username
        this.password = password
        this.role = role
        this.cards = cards
    }

    addCard(card: Card) : void {
        this.cards?.push(card)
    }

}