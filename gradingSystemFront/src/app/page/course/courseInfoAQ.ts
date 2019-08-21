import { Profile } from '../user-profile/profile';
import { AssignmentInfo } from './assignmentInfo';
import { QuizInfo } from './quizInfo';

export class CourseInfoAQ{ 
    id: number;
    name: string;
    description: string;   
    teacher: Profile;
    assignments: AssignmentInfo[];
    quizzes: QuizInfo[];

}