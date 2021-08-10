import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { User } from '@/_models';
import { UserService, AuthenticationService } from '@/_services';
import {ClienteService} from "@/_services/cliente.service";

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent implements OnInit {
    currentUser: User;
    clientes = [];

    constructor(
        private authenticationService: AuthenticationService,
        private clienteService: ClienteService
    ) {
        this.currentUser = this.authenticationService.currentUserValue;
    }

    ngOnInit() {
        this.loadAllUsers();
    }

    deleteUser(id: number) {
        this.clienteService.delete(id)
            .pipe(first())
            .subscribe(() => this.loadAllUsers());
    }

    private loadAllUsers() {
        this.clienteService.getAll()
            .pipe(first())
            .subscribe(clientes => this.clientes = clientes);
    }
}
