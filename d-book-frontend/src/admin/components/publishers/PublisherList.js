import React from 'react';
import { Datagrid, DeleteButton, EditButton, List, TextField } from 'react-admin';

const PublisherList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="id" />
            <TextField source="name" />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);

export default PublisherList;