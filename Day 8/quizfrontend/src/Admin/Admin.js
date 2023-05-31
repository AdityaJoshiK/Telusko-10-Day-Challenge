import React from 'react';
import { Outlet } from 'react-router-dom';
import AdminNav from './Navbar';

export default function Admin() {
  return (
    <>
     <AdminNav/>
     <Outlet/>
    </>
  )}