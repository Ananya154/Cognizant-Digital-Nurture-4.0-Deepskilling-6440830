import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [view, setView] = useState('');

  let content;
  if (view === 'books') {
    content = <BookDetails />;
  } else if (view === 'blogs') {
    content = <BlogDetails />;
  } else if (view === 'courses') {
    content = <CourseDetails />;
  } else {
    content = <p>Please select a section to view.</p>;
  }

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Blogger App</h1>

      {/* Button controls (short-circuit rendering, ternary inside click) */}
      <div>
        <button onClick={() => setView('books')}>View Books</button>
        <button onClick={() => setView('blogs')}>View Blogs</button>
        <button onClick={() => setView('courses')}>View Courses</button>
        <button onClick={() => setView('')}>Clear</button>
      </div>

      <hr />
      {/* Conditional Rendering output */}
      {content}
    </div>
  );
}

export default App;
