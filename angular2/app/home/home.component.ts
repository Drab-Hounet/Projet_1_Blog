import { Component, OnInit } from '@angular/core';

import { User } from '../_models/index';
import { UserService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'home.component.html'
})

export class HomeComponent implements OnInit {
    currentUser: User;
    users: User[];

    constructor(private userService: UserService) {
    }

    ngOnInit() {
        this.loadAllUsers();
    }

    deleteUser(id: string) {
        this.userService.removeUser(id).subscribe(() => { this.loadAllUsers() });
    }

    private loadAllUsers() {
        this.userService.getUsers().subscribe(users => { 
            
            this.users = users; 
            console.log(users);
        });
        
    }
}