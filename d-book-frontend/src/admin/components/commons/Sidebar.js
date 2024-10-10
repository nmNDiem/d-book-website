import React from 'react';
import { Nav } from 'react-bootstrap';
import './SidebarStyle.css'

const Sidebar = () => {
    return (
        <div>
            <div className="sidebar">
                <Nav className="flex-column">
                    <Nav.Link href="#books">Book List</Nav.Link>
                    <Nav.Link href="#add-book">Add Book</Nav.Link>
                    <Nav.Link href="#edit-book">Edit Book</Nav.Link>
                </Nav>
            </div>
        </div>
    );
};

export default Sidebar;