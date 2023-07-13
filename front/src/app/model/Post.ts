export class Post {
    id?: number
    imagePath?: string
    description?: string
    likeCount?: string



    constructor(imagePath:string, description:string, likeCount:string) {
        this.imagePath=imagePath;
        this.description=description;
        this.likeCount=likeCount;
    }
    
}