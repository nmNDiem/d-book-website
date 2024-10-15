import React from 'react';
import { Datagrid, DeleteButton, EditButton, List, TextField } from 'react-admin';

const AuthorList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="id" />
            <TextField source="name" />
            <TextField source="bio" />
            <TextField source="createdTime" />
            <TextField source="updatedTime" />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);

export default AuthorList;