import type { ErrorInfo } from "react";
import type Post from "./Post";
import { Component } from "react";

export class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        };
    }
    
     loadPosts = async () => {
        const response = await fetch('https://jsonplaceholder.typicode.com/posts');
        const data:Post[] = await response.json();
        this.setState({ posts: data });
    }        

    
    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error: Error, errorInfo: ErrorInfo): void {
        console.error("Error occurred while fetching posts:", error, errorInfo);
    }

    render() {
        const { posts } = this.state;
        return (
            <div>
                <h1>Posts</h1>
                <ul>
                    {posts.map((post: Post) => (
                        <li key={post.id}>
                            <h2>{post.title}</h2>
                            <p>{post.body}</p>
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
}
