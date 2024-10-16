import React from 'react';
import { Create, Edit, SimpleForm, TextInput } from 'react-admin';

const AuthorCreate = (props) => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="name" />
            <TextInput source="bio" />
        </SimpleForm>
    </Create>
);

export default AuthorCreate;