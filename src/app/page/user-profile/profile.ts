import { CourseNameId } from './course-name-id';

export class Profile{ 
    username: string;
    nume: string;
    email: string;
    role: string;
    adresa: string;
    grupa: number;
    courses: CourseNameId[];
}