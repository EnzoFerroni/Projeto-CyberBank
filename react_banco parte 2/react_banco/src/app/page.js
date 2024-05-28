'use client';
import Link from "next/link";
import Login from "./Componentes/Login";
import "./home.css";
import Menu from "./Componentes/Menu";

export default function Home(){
  return(
    <>
    <Menu></Menu>
    <Login></Login>
    </>

  );
}