
-- получение всех пользователей, у которые находятся в опубликованном курсе

select c.id
from course c
where c.state = 'PUBLISHED';

-- получение id пользователей, которые находятся в опубликованном курсе

explain analyse select *
                from account a
                         join (select sc.student_id
                               from student_course sc
                                        join (select c.id
                                              from course c
                                              where c.state = 'PUBLISHED') published_courses
                                             on sc.course_id = published_courses.id) student_in_published_course
                              on a.id = student_in_published_course.student_id;

explain analyse select *
                from account
                         join student_course on account.id = student_course.student_id
                         join course on course.id = student_course.course_id
                where course.state = 'PUBLISHED';
