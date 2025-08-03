import React from 'react';

function BlogDetails() {
  const blogs = [
    { id: 1, title: 'React Tips', date: '2024-06-01' },
    { id: 2, title: 'JS Tricks', date: '2024-05-22' }
  ];

  return (
    <div>
      <h2> Blog Posts</h2>
      <ul>
        {blogs.map(blog => (
          <li key={blog.id}>
            {blog.title} (Published: {blog.date})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails;
