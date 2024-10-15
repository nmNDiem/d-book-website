import React from 'react';
import { Datagrid, DeleteButton, EditButton, ImageField, List, TextField } from 'react-admin';

const BannerList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="id" />
            <ImageField source="image" label="Image" />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);

export default BannerList;