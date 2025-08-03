import React from 'react';

function BookDetails() {
  const books = [
    { id: 1, title: 'Clean Code', author: 'Robert C. Martin' },
    { id: 2, title: 'You Don’t Know JS', author: 'Kyle Simpson' },
    { id: 3, title: 'Atomic Habits', author: 'James Clear' }
  ];

  return (
    <div>
      <h2>Book List</h2>
      <ul>
        {books.map(book => (
          <li key={book.id}>
            {book.title} by <strong>{book.author}</strong>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;
