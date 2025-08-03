import React from 'react';

function CourseDetails() {
  const courses = [
    { id: 1, name: 'React Bootcamp', duration: '4 Weeks' },
    { id: 2, name: 'JavaScript Mastery', duration: '6 Weeks' }
  ];

  return (
    <div>
      <h2> Available Courses</h2>
      <ul>
        {courses.map(course => (
          <li key={course.id}>
            {course.name} - {course.duration}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;
