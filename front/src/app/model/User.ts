import { Role } from "./Role"

export class User {
    id?: string
    username: string
    password?: string
    role?: Role 

    constructor(id: string, username: string, password: string, role: Role) {
        this.id = id
        this.username = username
        this.password = password
        this.role = role
    }

}