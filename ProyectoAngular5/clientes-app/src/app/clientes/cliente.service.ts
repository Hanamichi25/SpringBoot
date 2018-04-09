import { Injectable } from '@angular/core';
import { CLIENTES } from './clientes.json';
import { Cliente } from './cliente';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable()
export class ClienteService {
  private urlEndPont:string = 'http://localhost:8090/api/clientes';
  private httpHeaders = new HttpHeaders({'Content-type':'application/json'});
  constructor(private http: HttpClient) { }

  getClientes(): Observable<Cliente[]>{
    //return of(CLIENTES);
    return this.http.get<Cliente[]>(this.urlEndPont);
  }

  create(cliente: Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(this.urlEndPont, cliente, {headers: this.httpHeaders});
  }

  getCliente(id): Observable<Cliente>{
    return this.http.get<Cliente>(`${this.urlEndPont}/${id}`);
  }

  update(cliente:Cliente): Observable<Cliente>{
    return this.http.put<Cliente>(`${this.urlEndPont}/${cliente.id}`,cliente,{headers: this.httpHeaders});
  }

  delete(id: number): Observable<Cliente>{
    return this.http.delete<Cliente>(`${this.urlEndPont}/${id}`,{headers: this.httpHeaders});
  }
}
