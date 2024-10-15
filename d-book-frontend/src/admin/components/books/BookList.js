import React from 'react';
import { Datagrid, DeleteButton, EditButton, ImageField, List, TextField } from 'react-admin';

const BookList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="id" />
            <TextField source="title" />
            <ImageField source="image" label="Image" />
            <TextField source="pages" />
            <TextField source="isbn" />
            <TextField source="description" />
            <TextField source="publishedYear" />
            <TextField source="price" />
            <TextField source="discountPercent" />
            <TextField source="rating" />
            <TextField source="stock" />
            <TextField source="active" />
            <TextField source="createdTime" />
            <TextField source="updatedTime" />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);

export default BookList;