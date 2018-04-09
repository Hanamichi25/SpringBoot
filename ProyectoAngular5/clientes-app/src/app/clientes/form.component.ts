import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from "sweetalert2";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {
  private cliente: Cliente = new Cliente();
  private titulo:string = "Crear cliente";
  constructor(private clienteService: ClienteService,
              private router:Router,
              private activateRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarCliente();
  }

  public create(): void{
    this.clienteService.create(this.cliente).subscribe(
      cliente => {
        this.router.navigate(['/clientes'])
        swal('Nuevo Cliente',`Cliente ${cliente.nombre} creado con éxito!`,'success')
      }
    );
  }

  cargarCliente():void{
    this.activateRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.clienteService.getCliente(id).subscribe((cliente) => this.cliente = cliente)
      }
    })
  }

  update():void{
    this.clienteService.update(this.cliente).subscribe(cliente => {
      this.router.navigate(['/clientes'])
      swal('Cliente actualizaco',`Cliente ${cliente.nombre} actualizado con éxtio!`,'success')
    })
  }

}
