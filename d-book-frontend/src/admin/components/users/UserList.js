import React from 'react';
import { Datagrid, DeleteButton, EditButton, ImageField, List, TextField } from 'react-admin';

const UserList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="id" />
            <ImageField source="avatar" label="Avatar" />
            <TextField source="email" />
            <TextField source="fullName" />
            <TextField source="dob" />
            <TextField source="title" />
            <TextField source="phone" />
            <TextField source="address" />
            <TextField source="active" />
            <TextField source="createdTime" />
            <TextField source="updatedTime" />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);

export default UserList;