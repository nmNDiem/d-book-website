import React from 'react';
import { List, Datagrid, TextField, EditButton, DeleteButton } from 'react-admin';

export const CategoryList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="id" />
            <TextField source="name" />
            <TextField source="description" />
            <TextField source="active" />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);