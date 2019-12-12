package main.modelo.juego;

public abstract class Bando {
   public abstract Bando identificarBando(EquipoBlanco equipoBlanco, EquipoNegro equipoNegro);
   public abstract Bando identificarBando(EquipoBlanco equipoBlanco1, EquipoBlanco equipoBlanco2);
   public abstract Bando identificarBando(EquipoNegro equipoNegro, EquipoBlanco equipoBlanco);
   public abstract Bando identificarBando(EquipoNegro equipoNegro1, EquipoNegro equipoNegro2);
}
