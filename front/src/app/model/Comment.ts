import { User } from "./User";

export class Comment {
    id?: number;
    text?: string;
    user?: User;
    createdAt?: string;

    constructor(id: number, text: string, user: User, createdAt: string) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.createdAt = createdAt;
    }
}
