CREATE TABLE STUDENTS (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY, -- generate uuid on creation
    age INTEGER NOT NULL,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL
);

CREATE TABLE TEACHERS (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    age INTEGER NOT NULL,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL
);

-- join table (many-many)
CREATE TABLE STUDENT_TEACHER (
    student_id UUID NOT NULL,
    teacher_id UUID NOT NULL,
    PRIMARY KEY (student_id, teacher_id),
    FOREIGN KEY (student_id) references STUDENTS(id),
    FOREIGN KEY (teacher_id) references TEACHERS(id)
);