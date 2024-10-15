import React from 'react';
import { BooleanInput, Create, SimpleForm, TextInput } from 'react-admin';

export const CategoryCreate = (props) => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="name" />
            <TextInput source="description" />
            <BooleanInput source="active" />
        </SimpleForm>
    </Create>
);
