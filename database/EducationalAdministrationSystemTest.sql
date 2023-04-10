/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/12/12 14:51:15                          */
/*==============================================================*/


drop table if exists Administrator;

drop table if exists Adviser;

drop table if exists Class;

drop table if exists ClassCourseRelationship;

drop table if exists ClassStudentTeacherRelationship;

drop table if exists Course;

drop table if exists CourseStudentTeacherRelationship;

drop table if exists CourseTime;

drop table if exists CourseTimeRelationship;

drop table if exists Evaluation;

drop table if exists EvaluationClassTeacherReationship;

drop table if exists EvaluationStudentTeacherReationship;

drop table if exists Studen;

drop table if exists StudentAdviserRelationship;

drop table if exists StudentTeacherRelationship;

drop table if exists Teacher;

/*==============================================================*/
/* Table: Administrator                                         */
/*==============================================================*/
create table Administrator
(
   administrators_id    int not null auto_increment,
   administrators_name  varchar(30),
   administrators_phone varchar(50),
   administrators_password varchar(50),
   salt                 varchar(50),
   primary key (administrators_id)
)comment="管理员表";

/*==============================================================*/
/* Table: Adviser                                               */
/*==============================================================*/
create table Adviser
(
   adviser_id           int not null auto_increment,
   adviser_name         varchar(50),
   adviser_phone        varchar(50),
   adviser_password     varchar(50),
   salt                 varchar(50),
   adviser_age          int,
   adviser_major        varchar(30),
   adviser_qualification varchar(30),
   adviser_university   varchar(30),
   adviser_title        varchar(30),
   adviser_adviseExperience int,
   primary key (adviser_id)
)comment="顾问表";

/*==============================================================*/
/* Table: Class                                                 */
/*==============================================================*/
create table Class
(
   class_id             int not null auto_increment,
   class_name           varchar(30),
   primary key (class_id)
)comment="班级表";

/*==============================================================*/
/* Table: ClassCourseRelationship                               */
/*==============================================================*/
create table ClassCourseRelationship
(
   classCourseRelationship int not null,
   course_id            int,
   class_id             int,
   primary key (classCourseRelationship)
)comment="班级和课程关系表";

/*==============================================================*/
/* Table: ClassStudentTeacherRelationship                       */
/*==============================================================*/
create table ClassStudentTeacherRelationship
(
   classStudentTeacherRelationship_id int not null auto_increment,
   class_id             int,
   student_id           int,
   teacher_id           int,
   primary key (classStudentTeacherRelationship_id)
)comment="班级和学生和老师表";

/*==============================================================*/
/* Table: Course                                                */
/*==============================================================*/
create table Course
(
   course_id            int not null auto_increment,
   course_name          varchar(30),
   primary key (course_id)
)comment="课程表";

/*==============================================================*/
/* Table: CourseStudentTeacherRelationship                      */
/*==============================================================*/
create table CourseStudentTeacherRelationship
(
   courseStudentTeacherRelationship_id int not null auto_increment,
   course_id            int,
   student_id           int,
   teacher_id           int,
   primary key (courseStudentTeacherRelationship_id)
)comment="课程和学生和老师关系表";

/*==============================================================*/
/* Table: CourseTime                                            */
/*==============================================================*/
create table CourseTime
(
   courseTime_id        int not null auto_increment,
   course_time          int,
   course_venue         varchar(30),
   primary key (courseTime_id)
)comment="课程时间表";

/*==============================================================*/
/* Table: CourseTimeRelationship                                */
/*==============================================================*/
create table CourseTimeRelationship
(
   courseTimeRelationship int not null auto_increment,
   course_id            int,
   courseTime_id        int,
   primary key (courseTimeRelationship)
)comment="课程时间关系表";

/*==============================================================*/
/* Table: Evaluation                                            */
/*==============================================================*/
create table Evaluation
(
   evaluation_id        int not null auto_increment,
   evaluation_date      datetime,
   primary key (evaluation_id)
)comment="评价表";

/*==============================================================*/
/* Table: EvaluationClassTeacherReationship                     */
/*==============================================================*/
create table EvaluationClassTeacherReationship
(
   evaluationClassTeacherReationship_id int not null auto_increment,
   evaluation_id        int,
   class_id             int,
   teacher_id           int,
   primary key (evaluationClassTeacherReationship_id)
)comment="评价和班级老师关系表";

/*==============================================================*/
/* Table: EvaluationStudentTeacherReationship                   */
/*==============================================================*/
create table EvaluationStudentTeacherReationship
(
   evaluationStudentTeacherReationship_id int not null auto_increment,
   evaluation_id        int,
   student_id           int,
   teacher_id           int,
   primary key (evaluationStudentTeacherReationship_id)
)comment="评价和学生和老师关系表";

/*==============================================================*/
/* Table: Studen                                                */
/*==============================================================*/
create table Student
(
   student_id           int not null auto_increment,
   student_name         varchar(50),
   student_sex          varchar(10),
   student_phone        varchar(50),
   student_password     varchar(50),
   salt                 varchar(50),
   student_classHours   int,
   student_school       varchar(30),
   student_major        varchar(30),
   student_grade        varchar(30),
   student_goAbroadTime date,
   student_describe     varchar(1000),
   student_parentPhone  int,
   student_failedCourses varchar(100),
   student_applicationObjective varchar(100),
   student_examinationTime date,
   primary key (student_id)
)comment="学生表";

/*==============================================================*/
/* Table: StudentAdviserRelationship                            */
/*==============================================================*/
create table StudentAdviserRelationship
(
   studentAdviserRelationship_id int not null auto_increment,
   student_id           int,
   adviser_id           int,
   primary key (studentAdviserRelationship_id)
)comment="学生顾问关系表";

/*==============================================================*/
/* Table: StudentTeacherRelationship                            */
/*==============================================================*/
create table StudentTeacherRelationship
(
   studentTeacherRelationship_id int not null auto_increment,
   student_id           int,
   teacher_id           int,
   primary key (studentTeacherRelationship_id)
)comment="学生老师关系表";

/*==============================================================*/
/* Table: Teacher                                               */
/*==============================================================*/
create table Teacher
(
   teacher_id           int not null auto_increment,
   teacher_name         varchar(50),
   teacher_phone        varchar(50),
   teacher_password     varchar(50),
   salt                 varchar(50),
   teacher_age          int,
   teacher_major        varchar(30),
   teacher_qualification varchar(30),
   teacher_university   varchar(30),
   teacher_title        varchar(30),
   teacher_teachingExperience int,
   primary key (teacher_id)
)comment="老师表";

alter table ClassCourseRelationship add constraint FK_Reference_19 foreign key (course_id)
      references Course (course_id) on delete restrict on update restrict;

alter table ClassCourseRelationship add constraint FK_Reference_20 foreign key (class_id)
      references Class (class_id) on delete restrict on update restrict;

alter table ClassStudentTeacherRelationship add constraint FK_Reference_16 foreign key (class_id)
      references Class (class_id) on delete restrict on update restrict;

alter table ClassStudentTeacherRelationship add constraint FK_Reference_17 foreign key (student_id)
      references Studen (student_id) on delete restrict on update restrict;

alter table ClassStudentTeacherRelationship add constraint FK_Reference_18 foreign key (teacher_id)
      references Teacher (teacher_id) on delete restrict on update restrict;

alter table CourseStudentTeacherRelationship add constraint FK_Reference_5 foreign key (course_id)
      references Course (course_id) on delete restrict on update restrict;

alter table CourseStudentTeacherRelationship add constraint FK_Reference_6 foreign key (student_id)
      references Studen (student_id) on delete restrict on update restrict;

alter table CourseStudentTeacherRelationship add constraint FK_Reference_7 foreign key (teacher_id)
      references Teacher (teacher_id) on delete restrict on update restrict;

alter table CourseTimeRelationship add constraint FK_Reference_8 foreign key (course_id)
      references Course (course_id) on delete restrict on update restrict;

alter table CourseTimeRelationship add constraint FK_Reference_9 foreign key (courseTime_id)
      references CourseTime (courseTime_id) on delete restrict on update restrict;

alter table EvaluationClassTeacherReationship add constraint FK_Reference_13 foreign key (evaluation_id)
      references Evaluation (evaluation_id) on delete restrict on update restrict;

alter table EvaluationClassTeacherReationship add constraint FK_Reference_14 foreign key (class_id)
      references Class (class_id) on delete restrict on update restrict;

alter table EvaluationClassTeacherReationship add constraint FK_Reference_15 foreign key (teacher_id)
      references Teacher (teacher_id) on delete restrict on update restrict;

alter table EvaluationStudentTeacherReationship add constraint FK_Reference_10 foreign key (evaluation_id)
      references Evaluation (evaluation_id) on delete restrict on update restrict;

alter table EvaluationStudentTeacherReationship add constraint FK_Reference_11 foreign key (student_id)
      references Studen (student_id) on delete restrict on update restrict;

alter table EvaluationStudentTeacherReationship add constraint FK_Reference_12 foreign key (teacher_id)
      references Teacher (teacher_id) on delete restrict on update restrict;

alter table StudentAdviserRelationship add constraint FK_Reference_3 foreign key (student_id)
      references Studen (student_id) on delete restrict on update restrict;

alter table StudentAdviserRelationship add constraint FK_Reference_4 foreign key (adviser_id)
      references Adviser (adviser_id) on delete restrict on update restrict;

alter table StudentTeacherRelationship add constraint FK_Reference_1 foreign key (student_id)
      references Studen (student_id) on delete restrict on update restrict;

alter table StudentTeacherRelationship add constraint FK_Reference_2 foreign key (teacher_id)
      references Teacher (teacher_id) on delete restrict on update restrict;

