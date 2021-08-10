import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Cliente} from "@/_models/cliente";

@Injectable({ providedIn: 'root' })
export class ClienteService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Cliente[]>(`${config.apiUrl}/clientes-list`);
    }

    register(cliente: Cliente) {
        return this.http.post(`${config.apiUrl}/save-cliente`, cliente,{headers : new HttpHeaders({ 'Content-Type': 'application/json' })});
    }

    delete(id: number) {
        return this.http.delete(`${config.apiUrl}/delete-cliente/${id}`);
    }
}
