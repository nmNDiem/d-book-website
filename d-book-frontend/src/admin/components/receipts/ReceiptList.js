import React from 'react';
import { Datagrid, DeleteButton, EditButton, List, TextField } from 'react-admin';

const ReceiptList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="id" />
            <TextField source="totalPrice" />
            <TextField source="createdTime" />
            <TextField source="paymentTime" />
            <TextField source="status" />
            <TextField source="customerName" />
            <TextField source="customerPhone" />
            <TextField source="customerEmail" />
            <TextField source="customerAddress" />
            <TextField source="paymentMethodName" />
            <TextField source="userName" />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);

export default ReceiptList;