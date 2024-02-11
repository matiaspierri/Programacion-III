export class Image {
    id?: string;
    title?: string;
    url?: string;

    constructor(id: string, title: string, url: string) {
        this.id = id;
        this.title = title;
        this.url = url;
    }
}
