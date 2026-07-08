import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'

type Book = {
  id: number;
  bname: string;
  price: number;
}

const books: Book[] = [
  {
    id:101,
    bname:'The Great Gatsby',
    price: 10.99,
  },
  {
    id:102,
    bname:'To Kill a Mockingbird',
    price: 12.99,
  },{
    id:103,
    bname:'project hail mary',
    price: 9.99,
  }
]

function BookDisplay({ book }: { book: Book }) {
  return (
    <div>
      <h2>{book.bname}</h2>
      <p>Price: ${book.price}</p>
    </div>
  );
}

function App() {

  return (
 <>
 {
  books.map((book) => ( 
    <BookDisplay key={book.id} book={book} />
  ))
 }
 </>
  )
}

export default App
